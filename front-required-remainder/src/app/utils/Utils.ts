export class Utils {

    static validateFieldsNumber() {

    }
    
    static valueIsNotNumber(value: any) {
        if(typeof value !== "number") return true; else return false;
    }
}