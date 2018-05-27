import { IUser } from './user';
import { IBranch } from './branch';

export interface ICandidate {
    candidateId: number;
    name: string ;
    fatherName: string;
    motherName: string;
    dob: Date;
    address: string;
    landmark: string;
    city: string;
    district: string;
    state: string;
    postalCode: string;
    religion: string;
    category: string;
    nationality: string;
    knownLanguages: string;
    primaryMobile: string;
    alternateMobile: string;
    rdbranch: any;
    photoId: number;
    bank: string;
    branch: string;
    ifscCode: string;
    accountNumber: string;
    createdOn: Date;
    createdBy: any;
    updatedOn: Date;
    updatedBy: any;
    active: boolean;
}
