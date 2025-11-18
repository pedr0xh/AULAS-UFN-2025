library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity motor is
    Port(
        enable    : in  std_logic;
        motor_out : out std_logic
    );
end motor;

architecture Behavioral of motor is
begin
    motor_out <= enable;
end Behavioral;
