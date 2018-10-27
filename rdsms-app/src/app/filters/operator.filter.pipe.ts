import {Pipe, PipeTransform} from '@angular/core';
import { IOperator } from '../models/operator';

@Pipe({
    name: 'operatorFilter'
})

export class OperatorFilterPipe implements PipeTransform {

    transform(items: IOperator[], searchText: string): IOperator[] {
        if (!items) {
            return [];
        }
        if (!searchText) {
            return items;
        }
        searchText = searchText.toString().toLowerCase();
        return items.filter(it => {
            return it.operatorName.toString().toLowerCase().includes(searchText);
        });
    }
}
