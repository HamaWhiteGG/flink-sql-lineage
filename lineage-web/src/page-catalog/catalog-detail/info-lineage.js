import React,{useState, useEffect} from 'react'
import { Descriptions,  Button, Collapse, Tabs} from 'antd'
import io from '@common/io-context'

const Cm = () => {
  // const getTableInfos = async () => {
  //   try {
  //     const res = await io.get(`/catalogs/${catalogId}/databases/${defaultDatabase}/tables/${tableName}`)
  //     console.log('getTableInfos---111', res)
  //   } catch (error) {
  //     message.error(error)
  //   }
  // }
  // useEffect(() => {
  //   getTableInfos()
  // }, [tableName])

  return (
    <div className='right-info-box'>
      lineage
    </div>
  )
}
export default Cm