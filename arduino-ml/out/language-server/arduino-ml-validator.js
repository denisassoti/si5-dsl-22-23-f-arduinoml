"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ArduinoMlValidator = exports.ArduinoMlValidationRegistry = void 0;
const langium_1 = require("langium");
/**
 * Registry for validation checks.
 */
class ArduinoMlValidationRegistry extends langium_1.ValidationRegistry {
    constructor(services) {
        super(services);
        const validator = services.validation.ArduinoMlValidator;
        const checks = {
        // Person: validator.checkPersonStartsWithCapital
        };
        this.register(checks, validator);
    }
}
exports.ArduinoMlValidationRegistry = ArduinoMlValidationRegistry;
/**
 * Implementation of custom validations.
 */
class ArduinoMlValidator {
    checkPersonStartsWithCapital(accept) {
        // if (person.name) {
        //     const firstChar = person.name.substring(0, 1);
        //     if (firstChar.toUpperCase() !== firstChar) {
        //         accept('warning', 'Person name should start with a capital.', { node: person, property: 'name' });
        //     }
        // }
    }
}
exports.ArduinoMlValidator = ArduinoMlValidator;
//# sourceMappingURL=arduino-ml-validator.js.map