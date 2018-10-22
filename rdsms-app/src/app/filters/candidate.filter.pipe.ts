import { Pipe, PipeTransform } from '@angular/core';
import { ICandidate } from '../models/candidate';

@Pipe({
    name: 'candidateFilter'
})

export class CandidateFilterPipe implements PipeTransform {

    transform(items: ICandidate[], searchText: string): ICandidate[] {
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
        console.log('Hiii ', it.name);
        return it.name.toLowerCase().includes(searchText);
        });
    }
}
