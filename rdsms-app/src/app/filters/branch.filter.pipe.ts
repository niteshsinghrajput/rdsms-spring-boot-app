import { Pipe, PipeTransform } from '@angular/core';
import { IBranch } from '../models/branch';

@Pipe({
    name: 'branchFilter'
})

export class BranchFilterPipe implements PipeTransform {

    transform(items: IBranch[], searchText: string): IBranch[] {
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
        return it.branchName.toString().toLowerCase().includes(searchText);
        });
    }
}
