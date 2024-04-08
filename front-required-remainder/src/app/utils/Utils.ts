export class Utils {
    static valueIsNotNumber(value: any) {
        if(typeof value !== "number") return true; else return false;
    }
}