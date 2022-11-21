import { Component, OnInit } from '@angular/core';
import { Item } from '../models/item';
import { LoggerService } from '../services/logger.service';

@Component({
  selector: 'app-shopping',
  templateUrl: './shopping.component.html',
  styleUrls: ['./shopping.component.css']
})
export class ShoppingComponent implements OnInit {

  constructor(private logger: LoggerService) { }

  ngOnInit(): void {
  }

  //String Interpolation Example
  message : string = "Hello There";

  //Property Binding Example
  place : string = "New York";

  //EventBinding
  printName():void {
    this.logger.log("I am using the logger service");
    alert("Hello There");
  }

  toggleDisplayText(): void {
    this.logger.error("Be careful!");
    this.check = !this.check;
  }

  //Structural Directive
  check: boolean = true;

  shoppingList: Item[] = [
    {
    itemName:'Apple',
    cost:0.4
    },
    {itemName:'Milk',
    cost:0.2
    }
]
}
