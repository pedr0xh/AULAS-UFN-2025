library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;


entity distribuidor is
generic (
CLK_FREQ_HZ : integer := 50000000; 
DEFAULT_INTERVAL_SEC : integer := 10 
);
port (
clk : in std_logic;
rst_n : in std_logic;
btn_manual : in std_logic; 
interval_set : in std_logic_vector(7 downto 0);
led_wait : out std_logic;
led_dispense: out std_logic;
led_motor : out std_logic;
motor_out : out std_logic
);
end entity;


architecture rtl of distribuidor is
signal interval_ticks : unsigned(31 downto 0);
signal interval_expired : std_logic;
signal motor_on : std_logic;
signal dispense_request : std_logic;


begin


process(interval_set)
variable secs : integer;
variable ticks : integer;
begin
secs := to_integer(unsigned(interval_set));
if secs = 0 then
secs := DEFAULT_INTERVAL_SEC;
end if;
ticks := secs * CLK_FREQ_HZ;
interval_ticks <= to_unsigned(ticks, 32);
end process;


timer_i: entity work.timer_counter
generic map (
WIDTH => 32
)
port map (
clk => clk,
rst_n => rst_n,
enable => '1',
limit => interval_ticks,
expired => interval_expired
);


fsm_i: entity work.fsm_controller
generic map (
end architecture;
