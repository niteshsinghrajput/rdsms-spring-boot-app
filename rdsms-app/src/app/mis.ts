export interface IMis {
    id: number;
    date: string;
    operator: string;
    partner: string;
    location: string;
    bni: number;
    chatId: number;
    circleId: string;
    type: string;
    totalCalls: number;
    failedCalls: number;
    unAnsweredCalls: number;
    switchedOff: number;
    userBusy: number;
    answeredCalls: number;
    durations: number;
    pulse: number;
    mous: number;
    hrs: number;
    att: number;
    failPercentage: number;
    callLessThanOneMin: number;
    mousLessThanOneMin: number;
    loginHours: number;
    firstPartyDisconnects: number;
    secondPartyDisconnects: number;
}
