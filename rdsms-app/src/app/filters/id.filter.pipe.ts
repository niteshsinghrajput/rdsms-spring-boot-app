import { Pipe, PipeTransform } from '@angular/core';
import { ID } from '../models/id';

@Pipe({
    name: 'idFilter'
})

export class IdFilterPipe implements PipeTransform {

    transform(items: ID[], searchText: string): ID[] {
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
        return it.idNumber.toString().toLowerCase().includes(searchText);
        });
    }
}
