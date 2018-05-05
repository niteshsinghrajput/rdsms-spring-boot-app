export interface IDsrBsnl {
    id: number;
    currentDate: Date;
    time: string;
    agentNo: number;
    chatId: number;
    vendor: string;
    location: string;
    lastLoginLogoutTime: Date;
    lastLoginLogoutStatus: string;
    status: string;
    hours: number;
    totalCalls: number;
    successCalls: number;
    failedCalls: number;
    unAnsweredCalls: number;
    switchedOff: number;
    userBusy: number;
    networkIssue: number;
    mou: number;
    active: boolean;
}
