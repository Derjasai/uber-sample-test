import GenericUser from "./GenericUser";

export default interface User extends GenericUser {
    cardNumber: string;
}