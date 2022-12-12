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
        .state("off") \
        .set("LED").to(LOW) \
        .when().either().key("a").or_("BUTTON").has_value(HIGH).go_to_state("on") \
        .state("on") \
        .set("LED").to(HIGH) \
        .when().key("e").go_to_state("off") \
        .get_contents()

    print(app)


if __name__ == '__main__':
    import sys
    with open('../generated/scenario6.ino', 'w') as sys.stdout:
        scenario6()
