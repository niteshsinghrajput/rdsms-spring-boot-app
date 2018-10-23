import { IRole } from './role';

export interface IUser {
    userId: number;
    name: string;
    email: string;
    mobile: string;
    userName: string;
    password: string;
    address: string;
    city: string;
    district: string;
    postalCode: string;
    roles: IRole[];
    active: boolean;
}
