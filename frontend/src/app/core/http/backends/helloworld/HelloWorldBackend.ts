import { HttpResponse } from '@/app/core/http/HttpResponse'
import { Greetings } from '@/app/core/http/backends/helloworld/model/Greetings'
import { BackendClient } from '@/app/core/http/backends/BackendClient'

/**
 * Backend class to call the HelloWorld backend service.
 */
export class HelloWorldBackend {
  private baseUrl: string;

  constructor (baseUrl: string) {
    this.baseUrl = baseUrl
  }

  greetings (): Promise<HttpResponse<Greetings>> {
    return BackendClient
      .get(this.baseUrl + '/greetings')
      .then(response => {
        return this.mapResponse(response)
      })
  }

  badRequest (): Promise<HttpResponse<Greetings>> {
    return BackendClient
      .get(this.baseUrl + '/bad-request')
      .then(response => {
        return this.mapResponse(response)
      })
  }

  private mapResponse (value: any): HttpResponse<Greetings> {
    return {
      statusCode: value.status,
      headers: value.headers,
      body: this.mapGreetings(value.data)
    }
  }

  private mapGreetings (value: any): Greetings {
    return {
      message: value.message
    }
  }
}
