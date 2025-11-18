library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;


entity tb_distribuidor is
end entity;


architecture sim of tb_distribuidor is
-- sinais de teste
signal clk : std_logic := '0';
signal rst_n : std_logic := '0';
signal btn_manual : std_logic := '0';
signal interval_set : std_logic_vector(7 downto 0) := (others => '0');
signal led_wait, led_dispense, led_motor : std_logic;
signal motor_out : std_logic;


constant CLK_PERIOD : time := 20 ns; -- 50 MHz


begin
-- instância DUT
dut: entity work.distribuidor_top
generic map (
CLK_FREQ_HZ => 50000000,
DEFAULT_INTERVAL_SEC => 5
)
port map (
clk => clk,
rst_n => rst_n,
btn_manual => btn_manual,
interval_set => interval_set,
led_wait => led_wait,
led_dispense => led_dispense,
led_motor => led_motor,
motor_out => motor_out
);


-- clock
clk_proc : process
begin
while now < 500 ms loop
clk <= '0';
wait for CLK_PERIOD/2;
clk <= '1';
wait for CLK_PERIOD/2;
end loop;
wait;
end process;


stim_proc: process
begin
-- reset
rst_n <= '0';
wait for 100 ns;
rst_n <= '1';


-- config: intervalo curto pra simulação: 1 segundo
interval_set <= std_logic_vector(to_unsigned(1, 8));


-- espera: timer deve expirar uma vez e ativar motor
wait for 1200 ms; -- aguarda mais que 1s para ver o ciclo
end architecture;
