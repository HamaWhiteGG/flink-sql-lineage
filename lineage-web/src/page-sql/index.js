import React,{ useState, useEffect } from 'react'
import { Outlet, useParams, useNavigate } from 'react-router-dom'
import { Spin, message } from 'antd'
import axios from 'axios'
import Monaco from 'react-monaco-editor'
import LeftBox from './job-sql'
import RinghtBox from './right-box'
import { Base64 } from 'js-base64'

import './index.css'


const Page = () => {
  const { id:taskId } = useParams()
  const [taskDetail, setTaskDetail] = useState({})
  const [lineageGraph, setLineageGraph] = useState({'nodes': [], 'links': []})
  const [catalogList, setCatalogList] = useState([])
  const [analysisLoading, setAnalysisLoading] = useState(false)

  const [value, setValue] = useState([
    '"use strict";',
    "function Person(age) {",
    "	if (age) {",
    "		this.age = age;",
    "	}",
    "}",
    "Person.prototype.getAge = function () {",
    "	return this.age;",
    "};",
  ]
  .join("\n")
  );

  // first into detail html
  const getDetail = async () => {
    try {
      const res = await axios.get(`tasks/${taskId}`);
      setLineageGraph(res.data.data.lineageGraph)
      setTaskDetail(res.data.data)
    } catch (error) {
      message.error(error)
    }
  }
  // get catologs
  const getCatalogList = async () => {
    try {
      const res = await axios.get('/catalogs')
      console.log('catalogs---', res)
      setCatalogList(res?.data?.data?.list)
    } catch (e) {
      message.error(e)
    }
  }

  // analysis SQL
  const analysisSql = async (id) => {
    setAnalysisLoading(true)
    try {
      const res = await axios.post(`/tasks/${taskId || id}/lineage`)
      setAnalysisLoading(false)
      setLineageGraph(res.data.data.lineageGraph)
      setTaskDetail(res.data.data)
      message.success(res.data.message)
    } catch (error) {
      message.error(error)
    }
  }

  useEffect(() => {
    taskId && getDetail();
  }, [taskId])

  useEffect(() => {
    getCatalogList()
  }, [])

  return (
    <div className='FBH' style={{height: '100%'}}>

      {/* editor */}
      <Outlet context={{analysisSql, catalogList}} />

      {/* lineage */}
      <div className='right-box'>
        <Spin spinning={analysisLoading} style={{  height: '100%', width: '100%' }}>
          <RinghtBox data={lineageGraph} taskDetail={taskDetail} catalogList={catalogList} />
        </Spin>
      </div>

    </div>
  )
}
export default Page