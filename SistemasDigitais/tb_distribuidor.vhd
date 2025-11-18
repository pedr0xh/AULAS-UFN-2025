library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity tb_distribuidor is
end tb_distribuidor;

architecture sim of tb_distribuidor is

    signal clk : std_logic := '0';
    signal reset : std_logic := '1';

    signal motor_out : std_logic;
    signal led_wait : std_logic;
    signal led_dispense : std_logic;

    component distribuidor
        Port(
            clk        : in  std_logic;
            reset      : in  std_logic;
            motor_out  : out std_logic;
            led_wait   : out std_logic;
            led_dispense : out std_logic
        );
    end component;

begin

    UUT: distribuidor
        port map(
            clk => clk,
            reset => reset,
            motor_out => motor_out,
            led_wait => led_wait,
            led_dispense => led_dispense
        );

    -- Clock 10ns período
    clk <= not clk after 5 ns;

    process
    begin
        reset <= '1';
        wait for 20 ns;
        reset <= '0';

        wait for 5 sec;  -- simula vários ciclos
        wait;
    end process;

end sim;
