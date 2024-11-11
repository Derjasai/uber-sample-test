import Driver from "./Driver";
import Payment from "./Payment";
import Position from "./Position";
import User from "./User";

enum RideStateType {
    WAITING_FOR_PICK_UP = "WAITING_FOR_PICK_UP",
    IN_PROGRESS = "IN_PROGRESS",
    COMPLETED = "COMPLETED",
    ACCEPTED = "ACCEPTED",
}

export default interface Ride {
    id: number;
    payment: Payment;
    user: User;
    driver: Driver;
    origin: Position;
    destination: Position;
    state: RideStateType;
}
