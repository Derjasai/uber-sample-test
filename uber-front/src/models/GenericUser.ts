import Position from "./Position";

export default interface GenericUser {
    id: number;
    externalId: string;
    firstName: string;
    lastName: string;
    documentNumber: string;
    phoneNumber: string;
    position: Position;
}
