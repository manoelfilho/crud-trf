import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpresaService } from '../services/empresa.service';
import { Empresa } from '../models/empresa';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-empresas-novo',
  templateUrl: './empresas-novo.component.html',
  styleUrls: ['./empresas-novo.component.css']
})
export class EmpresasNovoComponent implements OnInit {

  cepLocalizado = false;
  cepPesquisado = false;

  showError:boolean = false;
  showSuccess:boolean = false;
  erros: any = {};

  tipoEmpresaOptions = ['MATRIZ', 'FILIAL'];

  empresa: Empresa = {
    id: null,
    cnpj: '',
    nome: '',
    tipoEmpresa: this.tipoEmpresaOptions[0],
    razaoSocial: '',
    contato: '',
    email: '',
    cep: '',
    estado: '',
    bairro: '',
    cidade: '',
    logradouro: '',
    complemento: '',
  }

  constructor( 
    private activatedRoute: ActivatedRoute, 
    private empreService: EmpresaService,
    private _router: Router, 
    private _route: ActivatedRoute,
    private formBuilder: FormBuilder ) {
  }

  ngOnInit() {
    if( this._route.snapshot.paramMap.get("id") != null ){

      this.empreService.getEmpresaById(parseInt(this._route.snapshot.paramMap.get("id")))
      .pipe()
      .subscribe( res => {
        this.empresa = res;
      });

    }
  }

  buscaCEP(){
    this.empreService.buscaCEP(this.empresa.cep).subscribe((res:any) => {
      if(!res.erro){

        this.cepLocalizado = true;
        this.cepPesquisado = true;

        this.empresa.bairro = res.bairro;
        this.empresa.complemento = res.complemento;
        this.empresa.cidade = res.localidade;
        this.empresa.estado = res.uf;
        this.empresa.logradouro = res.logradouro;

      }else{
        this.cepLocalizado = false;
        this.cepPesquisado = true;
      }
    });
  }

  salvarEmpresa(){
    this.empreService.saveEmpresa(this.empresa)
    .pipe(
      catchError( er => {
        this.showError = true;
        this.showSuccess = false;
        this.erros = er;
        return Observable.throw(er.statusText);
      })
    )
    .subscribe( res => {
      this.showSuccess = true;
      this.showError = false;
    });
  }

  listEmpresas(){
    this._router.navigate(['/empresas']);
  }

}
