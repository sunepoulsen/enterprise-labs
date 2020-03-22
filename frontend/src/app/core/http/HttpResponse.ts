export interface HttpResponse<T> {
  statusCode: number;
  headers?: Map<string, string>;
  body?: T;
}
