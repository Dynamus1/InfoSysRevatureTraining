import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-poke-card',
  templateUrl: './poke-card.component.html',
  styleUrls: ['./poke-card.component.css']
})
export class PokeCardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input()
  pokeData !: any;
  // pokemonId: number = 0;
  // pokemonName: string = "";
  // pokemonUrl: string = "";
}
