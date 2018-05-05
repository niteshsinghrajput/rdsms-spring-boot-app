export interface IDsrVodafone {
    id: number;
    circle: string;
    agentLocation: string;
    reportDateTime: Date;
    detailHours: number;
    loginLogoutTime: Date;
    chatId: number;
    loginLogoutStatus: string;
    ani: number;
    vendor: string;
    location: string;
    loginLogoutTimeMins: number;
    status: string;
    category: string;
    priority: number;
    totalCalls: number;
    successCalls: number;
    failedCalls: number;
    pulses: number;
    aPartyDisconnects: number;
    unAnswered: number;
    switchedOff: number;
    active: boolean;
}
