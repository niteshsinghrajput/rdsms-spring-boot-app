import { IRole } from '../role';

export class User {
    userId: number;
    email: string;
    userName: string;
    password: string;
    roles: IRole[];
}
