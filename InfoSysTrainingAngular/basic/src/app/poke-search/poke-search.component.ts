import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { Pokemon } from '../models/pokemon';

@Component({
  selector: 'app-poke-search',
  templateUrl: './poke-search.component.html',
  styleUrls: ['./poke-search.component.css']
})
export class PokeSearchComponent implements OnInit {

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
  }

  pokeApiUrl: string = 'https://pokeapi.co/api/v2/pokemon/';
  poke_id: string = '';
  pokeData: any;
  foundPokemon: boolean = false;

  searchPokemon(){
    this.getPokemon(this.poke_id);
  }

  getPokemon(pokeId: string){
    this.http.get<any>(this.pokeApiUrl + pokeId)
    .pipe(
      tap(val => console.log(val))
    )
    .subscribe(data => {
      this.pokeData = data;
      console.log(this.pokeData);
      this.foundPokemon = true;
    });
  }
}
