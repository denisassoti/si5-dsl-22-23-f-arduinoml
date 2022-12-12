def scenario6():
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

    app = AppBuilder("Scenario6") \
        .sensor("BUTTON").on_pin(9) \
        .actuator("LED").on_pin(12) \
        .actuator("BUZZER").on_pin(11) \
        .state("off") \
            .set("LED").to(LOW) \
            .set("BUZZER").to(LOW) \
            .when().key("a").go_to_state("on") \
        .state("on") \
            .set("LED").to(HIGH) \
            .set("BUZZER").to(HIGH) \
            .when().key("b").go_to_state("off") \
        .get_contents()

    print(app)


if __name__ == '__main__':
    import sys
    with open('../generated/remote_alarm.ino', 'w') as sys.stdout:
        scenario6()
