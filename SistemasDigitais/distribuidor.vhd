library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity distribuidor is
    Port(
        clk        : in  std_logic;
        reset      : in  std_logic;
        motor_out  : out std_logic;
        led_wait   : out std_logic;
        led_dispense : out std_logic
    );
end distribuidor;

architecture Behavioral of distribuidor is

    component timer
        Port(
            clk : in std_logic;
            reset : in std_logic;
            tick : out std_logic
        );
    end component;

    component motor
        Port(
            enable    : in  std_logic;
            motor_out : out std_logic
        );
    end component;

    type state_type is (ESPERA, DISPENSA);
    signal state, next_state : state_type;

    signal tick_s : std_logic := '0';
    signal motor_signal : std_logic := '0';

begin

    T1: timer port map(clk => clk, reset => reset, tick => tick_s);
    M1: motor port map(enable => motor_signal, motor_out => motor_out);

    process(clk, reset)
    begin
        if reset = '1' then
            state <= ESPERA;
        elsif rising_edge(clk) then
            state <= next_state;
        end if;
    end process;

    -- Lógica da FSM
    process(state, tick_s)
    begin
        motor_signal <= '0';
        led_wait <= '0';
        led_dispense <= '0';
        next_state <= state;

        case state is
            when ESPERA =>
                led_wait <= '1';
                if tick_s = '1' then
                    next_state <= DISPENSA;
                end if;

            when DISPENSA =>
                led_dispense <= '1';
                motor_signal <= '1';
                next_state <= ESPERA;
        end case;
    end process;

end Behavioral;
