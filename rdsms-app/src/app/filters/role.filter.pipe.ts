import { Pipe, PipeTransform } from '@angular/core';
import { IRole } from '../models/role';

@Pipe({
    name: 'filter'
})

export class RoleFilterPipe implements PipeTransform {

    transform(items: IRole[], searchText: string): IRole[] {
        if (!items) {
            return [];
        }
        if (!searchText) {
            return items;
        }
    searchText = searchText.toString().toLowerCase();
    console.log('Search Text : ', searchText);
    console.log('Items : ', items);
    return items.filter(it => {
        return it.roleName.toString().toLowerCase().includes(searchText);
        });
    }
}
