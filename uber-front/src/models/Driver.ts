import GenericUser from "./GenericUser";

export default interface Driver extends GenericUser {
    carPlates: string;
    carColor: string;
    carType: string;
}