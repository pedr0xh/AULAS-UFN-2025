library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity motor is
port (
clk : in std_logic;
rst_n : in std_logic;
enable : in std_logic; -- lógica que ativa o motor
motor_out : out std_logic; -- saída para o MOSFET/transistor
led_motor : out std_logic
);
end entity;


architecture rtl of motor is
begin
-- driver simples: passa enable direto para motor_out
-- em hardware real, não ligar o motor diretamente no pino, usar driver externo


process(clk)
begin
if rising_edge(clk) then
if rst_n = '0' then
motor_out <= '0';
led_motor <= '0';
else
motor_out <= enable;
led_motor <= enable;
end if;
end if;
end process;


end architecture;
