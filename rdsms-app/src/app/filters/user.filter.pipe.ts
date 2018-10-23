import { Pipe, PipeTransform } from '@angular/core';
import { IRole } from '../models/role';
import { IUser } from '../models/user';

@Pipe({
    name: 'filter'
})

export class UserFilterPipe implements PipeTransform {

    transform(items: IUser[], searchText: string): IUser[] {
        if (!items) {
            return [];
        }
        if (!searchText) {
            return items;
        }
    searchText = searchText.toString().toLowerCase();
    return items.filter(it => {
        return it.name.toString().toLowerCase().includes(searchText);
        });
    }
}
