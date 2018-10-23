import { Pipe, PipeTransform } from '@angular/core';
import { IDirector } from '../models/director';

@Pipe({
    name: 'directorFilter'
})

export class DirectorFilterPipe implements PipeTransform {

    transform(items: IDirector[], searchText: string): IDirector[] {
        if (!items) {
            return [];
        }
        if (!searchText) {
            return items;
        }
    searchText = searchText.toString().toLowerCase();
    return items.filter(it => {
        return it.directorName.toString().toLowerCase().includes(searchText);
        });
    }
}
