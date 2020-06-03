import { Component, OnInit } from '@angular/core';
import { Empresa } from '../models/empresa';
import { EmpresaService } from '../services/empresa.service';
import { NgForm } from '@angular/forms';
import { Pageable } from '../models/pageable';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.css']
})
export class EmpresasComponent implements OnInit {

  empresa = {} as Empresa;
  empresas: Empresa[];
  pageable: Pageable;

  public filter: any = {
      pagina: 1,
      tamanho: 10,
      nome: '',
      cnpj: ''
  };

  constructor( 
    private activatedRoute: ActivatedRoute, 
    private empreService: EmpresaService,
    private _router: Router, 
    private _route: ActivatedRoute ) {
    
    //Constrói o filtro para a query
    this.activatedRoute.queryParams.subscribe(params => {
      this.filter.pagina = params['pagina'] ? params['pagina'] : 1;
      this.filter.tamanho = params['tamanho'] ? params['tamanho'] : 10;
      this.filter.nome = params['nome'] ? params['nome'] : '';
      this.filter.cnpj = params['cnpj'] ? params['cnpj'] : '';
    });

  }

  onFilter() {
    this.filter.pagina = 1;
    this._router.navigate(['/empresas'], { queryParams: this.filter,  });
    this.getEmpresas();
  }

  newEmpresa(){
    this._router.navigate(['/empresas/adicionar']);
  }
  
  ngOnInit() {
    this.getEmpresas();
  }

  saveEmpresa(form: NgForm) {
    if (this.empresa.id !== undefined) {
      this.empreService.updateEmpresa(this.empresa).subscribe(() => {
        this.cleanForm(form);
      });
    } else {
      this.empreService.saveEmpresa(this.empresa).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  getEmpresas() {
    this.empreService.getEmpresas(this.filter).subscribe((pageable: Pageable) => {
      this.pageable = pageable;
      this.empresas = pageable.content;
    });
  }

  deleteEmpresa(empresa: Empresa) {
    this.empreService.deleteEmpresa(empresa).subscribe(() => {
      this.getEmpresas();
    });
  }

  editEmpresa(empresa: Empresa) {
    this._router.navigate(['/empresas/editar/'+empresa.id]);
  }

  cleanForm(form: NgForm) {
    this.getEmpresas();
    form.resetForm();
    this.empresa = {} as Empresa;
  }

  changePage(e){
    this.filter.pagina = e;
    this._router.navigate(['/empresas'], { queryParams: this.filter,  });
    this.getEmpresas();
  }

}
