<template>
    <div class="p-grid">
        <div class="p-col-12">
            <Card>
                <template slot="title">Basic types</template>
                <template slot="content">
                    <label-grid label="String" :width="labelWidth">{{ stringValue }}</label-grid>
                    <label-grid label="String with HTML" :width="labelWidth">{{ htmlValue }}</label-grid>
                    <label-grid label="Integer" :width="labelWidth">{{ intValue }}</label-grid>
                    <label-grid label="Float" :width="labelWidth">{{ floatValue }}</label-grid>
                    <label-grid label="Float with 2 decimals" :width="labelWidth">{{ floatValue.toFixed(2) }}</label-grid>
                    <label-grid label="Hex" :width="labelWidth">{{ hexValue }}</label-grid>
                    <label-grid label="Binary" :width="labelWidth">{{ binaryValue }}</label-grid>
                    <label-grid label="Octal" :width="labelWidth">{{ octValue }}</label-grid>
                    <label-grid label="Calculated value" :width="labelWidth">{{ 22 / 7 }}</label-grid>
                    <label-grid label="Object value" :width="labelWidth">{{ accountValue }}</label-grid>
                </template>
            </Card>
        </div>

        <div class="p-col-12">
            <Card>
                <template slot="title">Iteration</template>
                <template slot="content">
                    <ul>
                        <li v-for="account in accounts" v-bind:key="account.id">
                            {{ account.name }}
                        </li>
                    </ul>
                    <p>
                        And now we try to only iterate over accounts with even ids:
                    </p>
                    <ul>
                        <li v-for="account in accountsWithEvenIds()" v-bind:key="account.id">
                            {{ account.name }}
                        </li>
                    </ul>
                </template>
            </Card>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import LabelGrid from '@/app/shared/components/layouts/LabelGrid.vue'

class Account {
  id: number;
  private name: string;

  constructor (id: number, name: string) {
    this.id = id
    this.name = name
  }
}

@Component({
  components: {
    LabelGrid
  }
})
export default class VueComponentRender extends Vue {
  labelWidth = '180px'

  private stringValue: string;
  private htmlValue: string;
  private intValue: number;
  private floatValue: number;
  private hexValue: number;
  private binaryValue: number;
  private octValue: number;

  private accountValue: Account;
  private accounts: Account[];

  constructor () {
    super()
    this.stringValue = 'Company name'
    this.htmlValue = '<strong>Company name</strong> - a < b'
    this.intValue = 17
    this.floatValue = 22.0 / 7.0
    this.hexValue = 0xf00d
    this.binaryValue = 0x101100111
    this.octValue = 0o744
    this.accountValue = new Account(38, 'Financial records')

    this.accounts = [
      new Account(1, 'Account 1'),
      new Account(2, 'Account 2'),
      new Account(3, 'Account 3'),
      new Account(4, 'Account 4'),
      new Account(5, 'Account 5')
    ]
  }

  accountsWithEvenIds () {
    return this.accounts.filter(value => value.id % 2 === 0)
  }
}
</script>

<style scoped>
</style>
