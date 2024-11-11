export enum PaymentType {
    CREDIT_CARD = "CREDIT_CARD",
    DEBIT_CARD = "DEBIT_CARD",
    CASH = "CASH",
}

export default interface Payment {
    id: number;
    amount: number;
    currency: string;
    paymentType: PaymentType;
}
