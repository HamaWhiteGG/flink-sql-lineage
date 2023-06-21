import React,{useState, useEffect} from 'react'
import { Collapse, Table, Button, message, Typography, Badge, Avatar} from 'antd'
import dayjs from 'dayjs'
import io from '@common/io-context'


const { Panel } = Collapse
const { Text } = Typography
const Cm = (props) => {
  const {catalogId, defaultDatabase, functionId, databaseName} = props
  const [activeKey, setActiveKey] = useState('audit')
  const [dataList, setDataList] = useState([])
 
  const column = [{
    key: 'taskId',
    dataIndex: 'taskId',
    title: 'ID'
  },
  {
    key: 'taskName',
    dataIndex: 'taskName',
    title: 'Job Name'
  },
  {
    key: 'createTime',
    dataIndex: 'createTime',
    title: 'AnalyzeTime',
    render: (text, record) => {
      return <span>{dayjs(text).format('YYYY-MM-DD HH:mm:ss') ||  <Text type="secondary">--</Text>}</span>
    }
  },
  {
    key: 'sqlIdList',
    dataIndex: 'sqlIdList',
    title: 'Preview SQL',
    align: 'center',
    render: (text, record) => {
      return <Badge count={text.length} color='green' size="small"><Button type='link'>Preview</Button></Badge>
    }
  },
]

  const getTableInfos = async () => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/functions/${functionId}/tasks`)
      const {list: dataList = []} = res
      setDataList(dataList)
    } catch (error) {
      message.error(error)
    }
  }

  const onChange = (key) => {
    setActiveKey(key)
  }

  useEffect(() => {
    functionId && getTableInfos()
  }, [functionId])
  
  return (
    <div className='gray-bg pt8'>
      <Collapse ghost onChange={onChange} activeKey={activeKey}>
        <Panel className='white-bg' header="Audit" key="audit">
          <Table columns={column} dataSource={dataList} />
        </Panel>
      </Collapse>
    </div>
  )
}
export default Cm