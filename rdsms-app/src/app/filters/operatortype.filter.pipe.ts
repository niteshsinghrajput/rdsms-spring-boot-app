import { Pipe, PipeTransform } from '@angular/core';
import { IOperatorType } from '../models/operatortype';

@Pipe({
    name: 'operatorTypeFilter'
})

export class OperatorTypeFilterPipe implements PipeTransform {
    transform(items: IOperatorType[], searchText: string): IOperatorType[] {
        if (!items) {
            return [];
        }
        if (!searchText) {
            return items;
        }
    searchText = searchText.toString().toLowerCase();
    return items.filter(it => {
        return it.operatorType.toString().toLowerCase().includes(searchText);
    });
    }
}
