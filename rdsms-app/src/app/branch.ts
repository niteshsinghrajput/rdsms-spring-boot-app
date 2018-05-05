import { IUser } from './user';
import { IDirector } from './director';

export interface IBranch {
    branchId: number;
    branchName: string;
    address: string;
    city: string;
    district: string;
    createdOn: Date;
    createdBy: IUser;
    updatedOn: Date;
    updatedBy: IUser;
    director: IDirector;
    active: boolean;
}
