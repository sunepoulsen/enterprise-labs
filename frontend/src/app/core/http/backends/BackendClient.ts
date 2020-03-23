import { BackendError } from '@/app/core/http/backends/BackendError'
import { HttpResponse } from '@/app/core/http/HttpResponse'
import { v4 as uuidv4 } from 'uuid'
import Axios from 'axios'

export class BackendClient {
  static get (url: string) {
    return Axios.get(url, this.requestConfig())
  }

  static requestConfig () {
    return {
      headers: {
        'X-Request-ID': uuidv4()
      }
    }
  }

  static mapBackendError (error: any): HttpResponse<BackendError> {
    if (!error) {
      throw new Error(error.message)
    }

    if (!error.response) {
      throw new Error(error.message)
    }

    return {
      statusCode: error.response.status,
      headers: error.response.headers,
      body: {
        code: error.response.data.code,
        param: error.response.data.param,
        message: error.response.data.message
      }
    }
  }
}
