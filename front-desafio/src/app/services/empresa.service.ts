import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Empresa } from '../models/empresa';
import { Pageable } from '../models/pageable';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  url = 'http://localhost:8080/empresa';
  url_busca_cep = 'https://viacep.com.br/ws';

  constructor(private httpClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  getEmpresas(object_filter): Observable<Pageable> {
    return this.httpClient.get<Pageable>(this.url + `?pagina=${object_filter.pagina-1}&tamanho=${object_filter.tamanho}&nome=${object_filter.nome}&cnpj=${object_filter.cnpj}`)
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  getEmpresaById(id: number): Observable<Empresa> {
    return this.httpClient.get<Empresa>(this.url + '/' + id);
  }

  saveEmpresa(empresa: Empresa): Observable<Empresa> {
    return this.httpClient.post<Empresa>(this.url, JSON.stringify(empresa), this.httpOptions);
  }

  updateEmpresa(empresa: Empresa): Observable<Empresa> {
    return this.httpClient.put<Empresa>(this.url + '/' + empresa.id, JSON.stringify(empresa), this.httpOptions);
  }

  deleteEmpresa(empresa: Empresa) {
    return this.httpClient.delete<Empresa>(this.url + '/' + empresa.id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  buscaCEP(cep: string){
    return this.httpClient.get(this.url_busca_cep + '/' + cep + '/json')
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };
}