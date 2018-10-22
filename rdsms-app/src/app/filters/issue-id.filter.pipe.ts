import { Pipe, PipeTransform } from '@angular/core';
import { IdAllocation } from '../models/id-allocation';

@Pipe({
    name: 'filter'
})

export class IssueIdFilterPipe implements PipeTransform {

    transform(items: IdAllocation[], searchText: string): IdAllocation[] {
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
        return it.candidate.name.toString().toLowerCase().includes(searchText);
        });
    }
}
