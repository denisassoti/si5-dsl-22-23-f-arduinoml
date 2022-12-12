def scenario7():
    """
    Direct use of the DSL.
    + : auto-completion (limited due to python typing system)
    - : verbose, Python syntax requires '\' to cut lines.

    :return:
    """
    import sys
    sys.path.append('..')
    from AppBuilder import AppBuilder
    from model.SIGNAL import HIGH, LOW

    app = AppBuilder("Scenario1") \
        .sensor("BUTTON").on_pin(9) \
        .actuator("LED").on_pin(12) \
        .actuator("BUZZER").on_pin(11) \
        .state("off") \
            .set("LED").to(LOW) \
            .beep("BUZZER").short().times(1).long().times(1) \
            .when("BUTTON").has_value(HIGH).go_to_state("on") \
        .state("on") \
            .set("LED").to(HIGH) \
            .beep("BUZZER").short().times(2).long().times(1) \
            .when("BUTTON").has_value(HIGH).go_to_state("off") \
        .get_contents()

    print(app)


if __name__ == '__main__':
    import sys
    with open('../generated/beep_alarm.ino', 'w') as sys.stdout:
        scenario7()
