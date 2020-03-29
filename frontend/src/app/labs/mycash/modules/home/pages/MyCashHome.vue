<template>
  <div class="home p-grid p-justify-center">
    <div class="p-col-5">
      <h1>MyCash</h1>
      Welcome to the MyCash lab that demonstrates different features that  you normally will find
      in a finance management system.
      <p/>
      Before you can begin to use the lab you need to select the accounts you want to work on or
      create a new one:
      <p/>
      <DataTable :value="model" selectionMode="single" dataKey="id" :paginator="true" :rows="10">
        <Column field="name" header="Name" />
        <Column field="description" header="Description" />
        <Column field="startDate" header="Start">
          <template #body="slotProps">
            <span>{{formatDate(slotProps.data.startDate)}}</span>
          </template>
        </Column>
        <Column field="endDate" header="End">
          <template #body="slotProps">
            <span>{{formatDate(slotProps.data.endDate)}}</span>
          </template>
        </Column>
        <Column field="status" header="Status">
          <template #body="slotProps">
            <span v-if="slotProps.data.status === 0">ACTIVE</span>
            <span v-else-if="slotProps.data.status === 1" style="color: red;">CLOSED</span>
          </template>
        </Column>
      </DataTable>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { Accounting, AccountingStatus } from '@/app/labs/mycash/model/Accounting'
import moment, { Moment } from 'moment'

@Component
export default class MyCashHome extends Vue {
  private model: Accounting[] = [
    {
      id: 1,
      name: 'Private',
      description: 'Private accounting for Sune Thomas Poulsen',
      startDate: moment(new Date(2020, 0, 1)),
      endDate: moment(new Date(2020, 11, 31)),
      status: AccountingStatus.ACTIVE
    },
    {
      id: 2,
      name: 'Private',
      description: 'Private accounting for Sune Thomas Poulsen',
      startDate: moment(new Date(2019, 0, 1)),
      endDate: moment(new Date(2019, 11, 31)),
      status: AccountingStatus.CLOSED
    }
  ]

  formatDate (date: Moment) {
    return date.format('DD.MM.YYYY')
  }
}
</script>
