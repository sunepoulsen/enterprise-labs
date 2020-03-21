<template>
    <div>
        <h1>VUE Component Rendering</h1>

        <div class="p-grid">
            <div class="p-col-12">
                <Card>
                    <template slot="title">Basic types</template>
                    <template slot="content">
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">String:</div>
                            <div class="p-col">{{ stringValue }}</div>
                        </div>
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">String with HTML:</div>
                            <div class="p-col">{{ htmlValue }}</div>
                        </div>
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">Integer:</div>
                            <div class="p-col">{{ intValue }}</div>
                        </div>
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">Float:</div>
                            <div class="p-col">{{ floatValue }}</div>
                        </div>
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">Float with 2 decimals:</div>
                            <div class="p-col">{{ floatValue.toFixed(2) }}</div>
                        </div>
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">Hex:</div>
                            <div class="p-col">{{ hexValue }}</div>
                        </div>
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">Binary:</div>
                            <div class="p-col">{{ binaryValue }}</div>
                        </div>
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">Octal:</div>
                            <div class="p-col">{{ octValue }}</div>
                        </div>
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">Calculated value:</div>
                            <div class="p-col">{{ 22 / 7 }}</div>
                        </div>
                        <div class="p-grid">
                            <div class="p-col-fixed label-col">Object value:</div>
                            <div class="p-col">{{ accountValue }}</div>
                        </div>
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
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'

class Account {
  id: number;
  private name: string;

  constructor (id: number, name: string) {
    this.id = id
    this.name = name
  }
}

@Component
export default class VueComponentRenderPage extends Vue {
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
    .label-col {
        width: 180px;
    }
</style>
