library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity timer is
    Port(
        clk   : in  std_logic;
        reset : in  std_logic;
        tick  : out std_logic
    );
end timer;

architecture Behavioral of timer is
    signal count : unsigned(27 downto 0) := (others => '0'); 
    constant MAX_COUNT : unsigned(27 downto 0) := x"5F5E0FF"; -- ~1s @ 100MHz
begin

    process(clk, reset)
    begin
        if reset = '1' then
            count <= (others => '0');
            tick  <= '0';
        elsif rising_edge(clk) then
            if count = MAX_COUNT then
                count <= (others => '0');
                tick  <= '1';
            else
                count <= count + 1;
                tick  <= '0';
            end if;
        end if;
    end process;

end Behavioral;
