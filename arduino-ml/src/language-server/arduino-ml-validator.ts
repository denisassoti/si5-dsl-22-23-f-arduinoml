import { ValidationAcceptor, ValidationChecks, ValidationRegistry } from 'langium';
import { ArduinoMlAstType } from './generated/ast';
import type { ArduinoMlServices } from './arduino-ml-module';

/**
 * Registry for validation checks.
 */
export class ArduinoMlValidationRegistry extends ValidationRegistry {
    constructor(services: ArduinoMlServices) {
        super(services);
        const validator = services.validation.ArduinoMlValidator;
        const checks: ValidationChecks<ArduinoMlAstType> = {
            // Person: validator.checkPersonStartsWithCapital
        };
        this.register(checks, validator);
    }
}

/**
 * Implementation of custom validations.
 */
export class ArduinoMlValidator {

    checkPersonStartsWithCapital( accept: ValidationAcceptor): void {
        // if (person.name) {
        //     const firstChar = person.name.substring(0, 1);
        //     if (firstChar.toUpperCase() !== firstChar) {
        //         accept('warning', 'Person name should start with a capital.', { node: person, property: 'name' });
        //     }
        // }
    }

}
