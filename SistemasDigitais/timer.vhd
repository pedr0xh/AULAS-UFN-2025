library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;


entity timer is
generic (
WIDTH : integer := 32
);
port (
clk : in std_logic;
rst_n : in std_logic;
enable : in std_logic;
limit : in unsigned(WIDTH-1 downto 0);
expired : out std_logic
);
end entity;


architecture rtl of timer is
signal cnt : unsigned(WIDTH-1 downto 0);
begin
expired <= '0';


process(clk)
begin
if rising_edge(clk) then
if rst_n = '0' then
cnt <= (others => '0');
expired <= '0';
else
if enable = '1' then
if cnt >= limit then
cnt <= (others => '0');
expired <= '1';
else
cnt <= cnt + 1;
expired <= '0';
end if;
else
cnt <= cnt;
expired <= '0';
end if;
end if;
end if;
end process;


end architecture;
