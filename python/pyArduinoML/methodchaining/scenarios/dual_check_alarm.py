def scenario2():
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

    app = AppBuilder("Scenario2") \
        .sensor("BUTTON1").on_pin(8) \
        .sensor("BUTTON2").on_pin(9) \
        .actuator("LED").on_pin(12) \
        .actuator("BUZZER").on_pin(11) \
        .state("off") \
            .set("LED").to(LOW) \
            .set("BUZZER").to(LOW) \
            .when().both("BUTTON1").has_value(HIGH).and_("BUTTON2").has_value(HIGH).go_to_state("on") \
        .state("on") \
            .set("LED").to(HIGH) \
            .set("BUZZER").to(HIGH) \
            .when().either("BUTTON1").has_value(LOW).or_("BUTTON2").has_value(LOW).go_to_state("off") \
        .get_contents()

    print(app)


if __name__ == '__main__':
    import sys
    with open('../generated/dual_check_alarm.ino', 'w') as sys.stdout:
        scenario2()
