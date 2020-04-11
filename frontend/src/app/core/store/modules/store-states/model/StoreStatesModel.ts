export class StoreStatesModel {
  name: string;
  address: string;

  constructor () {
    this.name = ''
    this.address = ''
  }

  clone (): StoreStatesModel {
    const model: StoreStatesModel = new StoreStatesModel()

    model.name = this.name
    model.address = this.address

    return model
  }
}
