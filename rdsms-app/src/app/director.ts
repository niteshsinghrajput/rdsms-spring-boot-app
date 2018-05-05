import { IUser } from './user';

export interface IDirector {

    directorId: number;
    directorName: string;
    photoId: number;
    fatherName: string;
    dob: Date;
    primaryMobile: string;
    alternateMobile: string;
    bankName: string;
    branchName: string;
    ifscCode: string;
    accountNumber: string;
    createdOn: Date;
    createdBy: IUser;
    updatedOn: Date;
    updatedBy: IUser;
    active: boolean;
}
