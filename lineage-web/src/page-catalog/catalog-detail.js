import React,{useState, useEffect} from 'react'
import { useParams, useOutletContext } from 'react-router-dom'
import { message } from 'antd'
import axios from 'axios'
import DetailTree from './detail-tree'
import DetailTableInfo from './detail-table-info'
import DetailFunctionInfo from './detail-function-info'



const Cm = () => {
  const { id: catalogId } = useParams()
  // get catalog detail
  const getCatalogDetail = async () => {
    try {
      const res = await axios.get(`/catalogs/${catalogId}`)
    } catch (error) {
      message.error(error)
    }
  }
  // get databases under this catalog
  const getDatabases = async () => {
    try {
      const res = await axios.get(`/catalogs/${catalogId}/databases`)
    } catch (error) {
      message.error(error)
    }
  }

  // get databases under this catalog
  const getDatabasesFun = async () => {
    try {
      const res = await axios.get(`/catalogs/${catalogId}/databases/default/functions`)
    } catch (error) {
      message.error(error)
    }
  }
  // get databases under this catalog
  const getDatabasesTable = async () => {
    try {
      const res = await axios.get(`/catalogs/${catalogId}/databases/default/tables`)
    } catch (error) {
      message.error(error)
    }
  }

  useEffect(() => {
    getDatabases()
    getDatabasesFun()
    getDatabasesTable()
  }, [])
  return (
    <div className='FBH FBJ'>
      <DetailTree />
      <DetailTableInfo />
      {/* <DetailFunctionInfo /> */}
    </div>
  )
}
export default Cm